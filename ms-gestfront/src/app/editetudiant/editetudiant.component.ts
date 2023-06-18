import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-editetudiant',
  templateUrl: './editetudiant.component.html',
  styleUrls: ['./editetudiant.component.css']
})
export class EditetudiantComponent {
  data :any
etudiant :any

  constructor( private httpClient:HttpClient,private route: ActivatedRoute,private router:Router) {
    
 
   }
   ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.httpClient.get(`http://localhost:8081/etudiants/${id}`)
      .subscribe(
        data => {
          this.etudiant = data;
          this.form.setValue({
            nom: this.etudiant.nom,
            prenom: this.etudiant.prenom,
            dateNaissance: this.etudiant.dateNaissance,
        cne:this.etudiant.cne,
        cin:this.etudiant.cin,
           numapp:this.etudiant.numapp,
           niveau:this.etudiant.niveau
          });
        }, error => {
          console.log(error);
        }
      );
  }
  
  form = new FormGroup({
    nom: new FormControl('', [Validators.required]),
    prenom: new FormControl('', [Validators.required]),
    dateNaissance: new FormControl('', [Validators.required]),
    cne: new FormControl('', [Validators.required]),
    cin: new FormControl('', [Validators.required]),
    numapp: new FormControl('', [Validators.required]),
    niveau: new FormControl('', [Validators.required])
  })
  submit(){
    const data = this.form.value;
    console.log(this.data)
    this.httpClient.put(`http://localhost:8081/etudiants/update/${this.etudiant.id}`, data)
    .subscribe(
      data =>{Swal.fire({
        icon: 'success',
        title: 'etudiant modifié avec succès',
        showConfirmButton: false,
        timer: 2000
      }).then(() => {
        window.history.back();
      });
      }, error=>{console.log('Erreur ',error);});

   
  }


}
