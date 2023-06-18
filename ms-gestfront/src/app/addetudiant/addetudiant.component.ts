import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-addetudiant',
  templateUrl: './addetudiant.component.html',
  styleUrls: ['./addetudiant.component.css']
})
export class AddetudiantComponent {


data :any

  constructor( private httpClient:HttpClient,private route: ActivatedRoute,private router:Router) {
    
 
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
  

  ngOnInit(): void {
  }
  submit() {
    const data = this.form.value;
    const filiereId = this.route.snapshot.params['id'];
    this.httpClient.post(`http://localhost:8081/filieres/filiere/${filiereId}/etudiant`, data)
      .subscribe(
        data =>{Swal.fire({
          icon: 'success',
          title: 'Etudiant ajouteé avec succès',
          showConfirmButton: false,
          timer: 2000
        });
        this.router.navigate(['']);
        }, error=>{console.log('Erreur ',error);});
      
  }
}


