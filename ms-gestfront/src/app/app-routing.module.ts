import { NgModule } from '@angular/core';
import { Routes, RouterModule }from '@angular/router';
import { EditfiliereComponent } from './editfiliere/editfiliere.component';
import { FilieresComponent } from './filieres/filieres.component';
import { AddfiliereComponent } from './addfiliere/addfiliere.component';
import { EtudiantsComponent } from './etudiants/etudiants.component';
import { AddetudiantComponent } from './addetudiant/addetudiant.component';
import { EditetudiantComponent } from './editetudiant/editetudiant.component';


const routes: Routes = [
  { path: 'update/:id',component:EditfiliereComponent},
  { path: '',component:FilieresComponent},
  { path: 'add',component:AddfiliereComponent},
  { path: 'get/:id',component:EtudiantsComponent},
  { path: 'adde/:id',component:  AddetudiantComponent },
  { path: 'updateetd/:id',component:  EditetudiantComponent},

  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
