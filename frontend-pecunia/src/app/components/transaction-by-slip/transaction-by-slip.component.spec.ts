import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionBySlipComponent } from './transaction-by-slip.component';

describe('TransactionBySlipComponent', () => {
  let component: TransactionBySlipComponent;
  let fixture: ComponentFixture<TransactionBySlipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransactionBySlipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionBySlipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
