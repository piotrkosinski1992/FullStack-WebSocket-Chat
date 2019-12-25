import {NgModule} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';


@NgModule({
  declarations: [],
  imports: [
    MatButtonModule, MatFormFieldModule, MatInputModule, MatCardModule, ScrollingModule, MatListModule, MatDividerModule
  ],
  exports: [
    MatButtonModule, MatFormFieldModule, MatInputModule, MatCardModule, ScrollingModule, MatListModule, MatDividerModule
  ]
})
export class MaterialModule {
}
