import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalCreateCategoryComponent } from './modal-create-category.component';

describe('ModalCreateCategoryComponent', () => {
  let component: ModalCreateCategoryComponent;
  let fixture: ComponentFixture<ModalCreateCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalCreateCategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalCreateCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
