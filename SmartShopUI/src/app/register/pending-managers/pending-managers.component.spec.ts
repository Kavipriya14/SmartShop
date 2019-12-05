import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingManagersComponent } from './pending-managers.component';

describe('PendingManagersComponent', () => {
  let component: PendingManagersComponent;
  let fixture: ComponentFixture<PendingManagersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingManagersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingManagersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
