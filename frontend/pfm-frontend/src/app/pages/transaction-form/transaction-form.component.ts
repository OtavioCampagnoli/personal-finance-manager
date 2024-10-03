import { Transaction } from './../../shared/model/transaction.model';
import { Component, OnInit } from '@angular/core';
import { error, log } from 'console';
import { Certificate } from 'crypto';
import { TransactionCategory } from 'src/app/shared/enum/transactionCategory.enum';
import { TransactionType } from 'src/app/shared/enum/transactionType.enum';
import { TransactionService } from 'src/app/shared/service/transaction.service';

@Component({
  selector: 'app-transaction-form',
  templateUrl: './transaction-form.component.html',
  styleUrls: ['./transaction-form.component.scss']
})
export class TransactionFormComponent implements OnInit {

  constructor(private service: TransactionService) { }

  listTransactions: Transaction[] = [];

  modelRegister: Transaction = new Transaction();

  modelSearch: Transaction = new Transaction();

  cols: any[] = [];

  ngOnInit(): void {

    this.cols = [
      { field: 'description', header: 'Descrição' },
      { field: 'amount', header: 'Valor' },
      { field: 'category', header: 'Categoria' },
      { field: 'type', header: 'Tipo' },
      { field: 'date', header: 'Data' },
      { field: 'createdAt', header: 'Criado em' }
    ];

    this.listAll();

  }

  listAll() {
    this.service.listAll().subscribe(
      (data) => {
        this.listTransactions = data;
        console.log(this.listTransactions);

      }, (error) => {
        console.log(error);
      });
  }

  save() {
    let transactionSaveTest = new Transaction();

    transactionSaveTest = {
      id: 3,
      amount: 2500.00,
      category: TransactionCategory.FOOD,
      type: TransactionType.INCOME,
      description: "IFOOD",
      date: new Date(2024, 10 - 1, 2)
    }

    this.service.save(transactionSaveTest).subscribe((data) => {
      console.log(JSON.stringify(transactionSaveTest));
    }, (error) => {
      console.log(error);
    });
  }

  edit(event?: any) {

  }

  resetformRegister() {

  }

  translateCategory(category: string): string {
    let value: string = '';

    const categoryEnum = TransactionCategory[category as keyof typeof TransactionCategory];

    switch (categoryEnum) {
      case TransactionCategory.ENTERTAINMENT:
        value = 'Entretenimento';
        break;
      case TransactionCategory.FOOD:
        value = 'Alimentação';
        break;
      case TransactionCategory.HEALTH:
        value = 'Saúde';
        break;
      case TransactionCategory.OTHER:
        value = 'Outro';
        break;
      case TransactionCategory.SALARY:
        value = 'Salário';
        break;
      case TransactionCategory.TRANSPORT:
        value = 'Transporte';
        break;
      default:
        value = '';
    }

    return value.toUpperCase();
  }

  transalateType(type: string) {
    let value: string = '';

    const typeEnum = TransactionType[type as keyof typeof TransactionType];

    switch (typeEnum) {
      case TransactionType.EXPENSE:
        value = 'Despesa';
        break;
      case TransactionType.INCOME:
        value = 'Renda';
        break;
      default:
        value = '';
    }

    return value.toUpperCase();
  }

}
