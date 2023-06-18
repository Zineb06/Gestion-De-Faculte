import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FilieresComponent } from './filieres/filieres.component';
import { EditfiliereComponent } from './editfiliere/editfiliere.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AddfiliereComponent } from './addfiliere/addfiliere.component';
import { EtudiantsComponent } from './etudiants/etudiants.component';
import { EditetudiantComponent } from './editetudiant/editetudiant.component';
import { AddetudiantComponent } from './addetudiant/addetudiant.component';
import { AppAssetsModule } from './app-assets.module';


@NgModule({
  declarations: [
    AppComponent,
    FilieresComponent,
    EditfiliereComponent,
    AddfiliereComponent,
    EtudiantsComponent,
    EditetudiantComponent,
    AddetudiantComponent

   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppAssetsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


