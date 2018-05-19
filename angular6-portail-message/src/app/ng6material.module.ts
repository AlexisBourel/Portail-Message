import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {  MatButtonModule, MatCheckboxModule, MatDatepickerModule,MatFormFieldModule, MatIconModule, MatNativeDateModule, MatInputModule, MatSelect, MatSelectModule, MatMenuModule, MatTableModule, MatPaginatorModule } from '@angular/material';

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
      MatTableModule,
      MatPaginatorModule
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
      MatButtonModule,
      MatTableModule,
      MatPaginatorModule

]
})
export class MaterialAppModule { }