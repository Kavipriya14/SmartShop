import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingManagersDetailsComponent } from './pending-managers-details.component';

describe('PendingManagersDetailsComponent', () => {
  let component: PendingManagersDetailsComponent;
  let fixture: ComponentFixture<PendingManagersDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingManagersDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingManagersDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
