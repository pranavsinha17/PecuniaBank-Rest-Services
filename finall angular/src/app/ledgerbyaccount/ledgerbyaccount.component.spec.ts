import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LedgerbyaccountComponent } from './ledgerbyaccount.component';

describe('LedgerbyaccountComponent', () => {
  let component: LedgerbyaccountComponent;
  let fixture: ComponentFixture<LedgerbyaccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LedgerbyaccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LedgerbyaccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
