import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionByChequeComponent } from './transaction-by-cheque.component';

describe('TransactionByChequeComponent', () => {
  let component: TransactionByChequeComponent;
  let fixture: ComponentFixture<TransactionByChequeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransactionByChequeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionByChequeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
