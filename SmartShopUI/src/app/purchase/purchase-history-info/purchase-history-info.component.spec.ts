import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseHistoryInfoComponent } from './purchase-history-info.component';

describe('PurchaseHistoryInfoComponent', () => {
  let component: PurchaseHistoryInfoComponent;
  let fixture: ComponentFixture<PurchaseHistoryInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchaseHistoryInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseHistoryInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
