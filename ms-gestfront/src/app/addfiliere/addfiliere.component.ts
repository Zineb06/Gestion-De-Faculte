import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-addfiliere',
  templateUrl: './addfiliere.component.html',
  styleUrls: ['./addfiliere.component.css']
})
export class AddfiliereComponent {
  constructor( private httpClient:HttpClient,private route: ActivatedRoute,private router:Router) {
    
 
  }
  form = new FormGroup({
    nom: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    type: new FormControl('', [Validators.required]),
    date_Ouverture: new FormControl('', [Validators.required]),
    departement: new FormControl('', [Validators.required]),
  })

  ngOnInit(): void {
  }
  submit() {
    const data = this.form.value;
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.httpClient.post(`http://localhost:8081/filieres/add`, data)
      .subscribe(
        data =>{Swal.fire({
          icon: 'success',
          title: 'filière ajouteé avec succès',
          showConfirmButton: false,
          timer: 2000
        });
        this.router.navigate(['']);
        }, error=>{console.log('Erreur ',error);});
      
  }
}
