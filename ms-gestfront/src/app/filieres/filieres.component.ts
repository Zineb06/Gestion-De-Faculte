import { Component } from '@angular/core';
import { data, error } from 'jquery';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-filieres',
  templateUrl: './filieres.component.html',
  styleUrls: ['./filieres.component.css']
})
export class FilieresComponent {
  ListFilieres:any;
  searchTerm: any;
  selectedFiliere:any
  showDetails:boolean = false;

  constructor(private httpClient:HttpClient,private router:Router,private route: ActivatedRoute){}
  ngOnInit(){
    this.httpClient.get("http://localhost:8081/filieres/get").subscribe(data=>{
      this.ListFilieres=data;
    }, error=>{console.log(error);}); 

  }
  deletefiliere(id : number) {
    this.httpClient.delete(`http://localhost:8081/filieres/delete/${id}`)
      .subscribe(
        data=>{console.log('La filière a été supprimée avec succès !');
        this.refreshFilieres();
        }, error=>{Swal.fire({
          icon: 'success',
          title: 'filiere supprimeé avec succès',
          showConfirmButton: false,
          timer: 2000
        });});
      
  }

refreshFilieres() {
  this.httpClient.get("http://localhost:8081/filieres/get").subscribe(data=>{
    this.ListFilieres=data;
  }, error=>{console.log(error);});
}


 
updatefiliere(id: number){
  this.router.navigate(['update', id]);
}



getetudiant(id: number) {
  this.router.navigate(['/get', id]);
}

addetudiant(id :number){
  this.router.navigate(['adde', id]);
}
 detail(id:number){
  this.router.navigate(['detail', id]);
 }

   
 showDetailsList(filiere: any) {
  this.ListFilieres.forEach((f: any) => {
      if (f === filiere) {
          f.showDetails = !f.showDetails;
      } else {
          f.showDetails = false;
      }
  });
}
  }



  


