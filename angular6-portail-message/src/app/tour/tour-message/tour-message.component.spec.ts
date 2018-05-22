import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TourMessageComponent } from './tour-message.component';

describe('TourMessageComponent', () => {
  let component: TourMessageComponent;
  let fixture: ComponentFixture<TourMessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TourMessageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TourMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
