import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {  MatButtonModule, MatCheckboxModule, MatDatepickerModule,MatFormFieldModule, MatIconModule, MatNativeDateModule, MatInputModule, MatSelect, MatSelectModule, MatMenuModule } from '@angular/material';

@NgModule({
  imports: [ 
      MatButtonModule,
      MatCheckboxModule,
      MatDatepickerModule,
      MatFormFieldModule,
      MatIconModule,
      MatNativeDateModule,
      MatInputModule,
      MatSelectModule,
      MatMenuModule,
      MatButtonModule,
 ],
  exports: [ 
      MatButtonModule,
      MatCheckboxModule,
      MatDatepickerModule,
      MatFormFieldModule,
      MatIconModule,
      MatNativeDateModule,
      MatInputModule,
      MatSelectModule,
      MatMenuModule,
      MatButtonModule

]
})
export class MaterialAppModule { }