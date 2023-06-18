import { Component } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-editfiliere',
  templateUrl: './editfiliere.component.html',
  styleUrls: ['./editfiliere.component.css']
})
export class EditfiliereComponent {
 
  data: any

  filiere: any;

  constructor( private httpClient:HttpClient,private route: ActivatedRoute, private router : Router) { }


  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.httpClient.get(`http://localhost:8081/filieres/${id}`)
      .subscribe(
        data => {
          this.filiere = data;
          this.form.setValue({
            nom: this.filiere.nom,
            description: this.filiere.description,
            date_Ouverture:this.filiere.date_Ouverture,
            type:this.filiere.type,
            departement:this.filiere.departement
          });
        }, error => {
          console.log(error);
        }
      );
  }

  form = new FormGroup({
    nom: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    type: new FormControl('', [Validators.required]),
    date_Ouverture: new FormControl('', [Validators.required]),
    departement: new FormControl('', [Validators.required]),
  })

  submit(){
    const data = this.form.value;
    console.log(this.data)
    this.httpClient.put(`http://localhost:8081/filieres/update/${this.filiere.id}`, data)
    .subscribe(
      data =>{ Swal.fire({
        icon: 'success',
        title: 'filiere modifié avec succès',
        showConfirmButton: false,
        timer: 2000
      });
      this.router.navigate(['']);
      }, error=>{console.log('Erreur ',error);});

   
  }

}
