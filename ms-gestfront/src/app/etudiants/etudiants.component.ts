import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import jsPDF from 'jspdf';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-etudiants',
  templateUrl: './etudiants.component.html',
  styleUrls: ['./etudiants.component.css']
})
export class EtudiantsComponent {
  ListEtudiants: any[] = [];
  searchTerm: any;
 
 
  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private router:Router){}
  ngOnInit() {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.httpClient.get<any>(`http://localhost:8081/filieres/get/${id}`).subscribe(data => {
        this.ListEtudiants = data.etudiants;
      }, error => {
        console.log(error);
      });
    });
  }
   
  deletetudiant(id : number) {
    this.httpClient.delete(`http://localhost:8081/etudiants/${id}`)
      .subscribe(
        data=>{Swal.fire({
          icon: 'success',
          title: 'etudiant suprimé avec succès',
          showConfirmButton: false,
          timer: 2000
        });
        this.refreshEtudiants();
        }, error=>{console.log('Erreur lors de la suppression ',error);});
      
  }

refreshEtudiants() {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.httpClient.get<any>(`http://localhost:8081/filieres/get/${id}`).subscribe(data => {
        this.ListEtudiants = data.etudiants;
      }, error => {
        console.log(error);});
      });
    }


    updatetudiant(id:number){
      this.router.navigate(['updateetd', id]);
    }



    filterData() {
      this.route.params.subscribe(params => {
        const id = +params['id'];
      if (!this.searchTerm) {
        // Si la recherche est vide, afficher toutes les données
        this.httpClient.get<any>(`http://localhost:8081/filieres/get/${id}`).subscribe(data => {
          this.ListEtudiants = data.etudiants;
        }, error => {
          console.log(error);
        });
      } else {
        // Sinon, filtrer les données en fonction de la recherche
        const filteredData = this.ListEtudiants.filter(etudiant =>
          Object.keys(etudiant).some(key => etudiant[key].toString().toLowerCase().includes(this.searchTerm.toLowerCase()))
        );
        this.ListEtudiants = filteredData;
      }
    } );
  }
   
    exporterEnPDF(etudiant: any) {
      
    // Générer le fichier PDF
    const doc = new jsPDF();
const imgData = './assets/fstbm-logo.jpeg';

const pdfWidth = doc.internal.pageSize.width;
const pdfHeight = doc.internal.pageSize.height;

// charger l'image centrée
doc.addImage(imgData, 'JPEG', pdfWidth / 2 - 15, 20, 50, 20);

// Ajouter une ligne horizontale juste après le logo
doc.setLineWidth(0.5);
doc.setDrawColor(0, 0, 0);
doc.line(10, 45, doc.internal.pageSize.width - 10, 45);

// Ajouter les informations de l'étudiant
let x = 10;
let y = 50;

doc.setFontSize(16);
doc.setFont('helvetica', 'bold');
doc.setTextColor('#000000');
doc.text('Attestation de scolarit\é', x+60, y);
y += 20;


doc.setFont('helvetica', 'normal');
doc.setTextColor('#000000');
doc.setFontSize(12);
doc.text(`Le Doyen de la faculté des Sciences et Technique Beni Mellal atteste que l\'étudiant ${etudiant.nom}${etudiant.prenom}`,x,y);
y += 7;

doc.text(`Code Nationale de l'Etudiant(CNE): ${etudiant.cne}`, x, y);
y += 7;

doc.text(`Numero de carte Nationale(CNIE) : ${etudiant.cin}`, x, y);
y += 7;


doc.text(`Né le  : ${etudiant.dateNaissance},est régulieérement inscrit a la faculté des Sciences et Technique de Beni Mellal `, x, y);
y += 7;

doc.text('pour l\'annee anniversitaire 2022/2023', x, +y);
y += 7;
doc.text(`Niveau : ${etudiant.niveau}`, x, y);
y += 7;

doc.text(`Filière : ${etudiant.filiere}`, x, y);
y+=7;

doc.text('Fait à Beni Mellal le ' + new Date().toLocaleDateString("fr-FR"), pdfWidth / 2, y, { align: 'center' });
y+=7;
doc.text('Le Doyen',pdfWidth / 2, y, { align: 'center' });

// Télécharger le fichier PDF
doc.save(`${etudiant.nom}-${etudiant.prenom}.pdf`);
}
  }
 