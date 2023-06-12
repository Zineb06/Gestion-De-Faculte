package com.zineb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "professeur")
public class Professeur {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String prenom;
		private String nom;
		private String email;
		private String tel;
		private String cin;
		private String departement;

		public Professeur() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Professeur(int id, String prenom, String nom, String email, String tel, String adresse,
				String departement) {
			super();
			this.id = id;
			this.prenom = prenom;
			this.nom = nom;
			this.email = email;
			this.tel = tel;
			this.cin = adresse;
			this.departement = departement;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getCin() {
			return cin;
		}

		public void setCin(String adresse) {
			this.cin = adresse;
		}

		public String getDepartement() {
			return departement;
		}

		public void setDepartement(String departement) {
			this.departement = departement;
		}

		@Override
		public String toString() {
			return "Professeur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", tel=" + tel
					+ ", cin=" + cin + ", departement=" + departement + "]";
		}

		
	
}
