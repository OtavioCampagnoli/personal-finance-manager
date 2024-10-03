import { TransactionFormComponent } from './pages/transaction-form/transaction-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  {path: 'transaction-form', component: TransactionFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports:
    [
      RouterModule,
      HttpClientModule
  ]
})
export class AppRoutingModule { }
