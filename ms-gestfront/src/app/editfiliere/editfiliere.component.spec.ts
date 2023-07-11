import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditfiliereComponent } from './editfiliere.component';

describe('EditfiliereComponent', () => {
  let component: EditfiliereComponent;
  let fixture: ComponentFixture<EditfiliereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditfiliereComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditfiliereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
