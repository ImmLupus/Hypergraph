#include <iostream>
#include <locale.h>
#include <fstream>
#include <conio.h>
using namespace std;
main(){
	setlocale(LC_ALL,"rus");
	ofstream out("input.txt");
	int n,m,i,j,q,s,k,p;
	char ch;
	cout<<"Введите количество критериев: ";
	cin>>k;
	cout<<"Введите количество вершин типа L и R: ";
	cin>>n;
	cout<<"Введите количество вершин типа I: ";
	cin>>m;
	int A[n][n][m][k];	//Стоимость ребер
	int B[m];	//Значение вершин типа I
	cout<<endl<<"Далее, введите веса ребер:"<<endl;
	for (p=0; p<k; p++){
		cout<<"По критерию номер "<<p+1<<":"<<endl;
		for (i=0; i<n; i++){
			for (j=0; j<n; j++){
				for (q=0; q<m; q++){
					cout<<"L"<<i<<" "<<"R"<<j<<" "<<"I"<<q<<" ";
					cin>>A[i][j][q][p];
				}
			}
		}
	}
	loop1:
	cout<<endl<<"Нажмите \'n\' чтобы перейти к следующему этапу, или \'r\' чтобы редактировать данные";
	loop:
	ch=getch();
	if (ch=='r'){
		cout<<endl<<endl<<"Введите номера вершин L R I, номер критерия и новый вес этого ребра (пять цифр): ";
		cin>>i>>j>>q>>p>>s;
		A[i][j][q][p-1]=s;
		cout<<endl;
		goto loop1;
	}
	if (ch=='n') {
		cout<<endl<<endl<<"Далее, введите значения для всех вершин типа I:"<<endl;
		for (i=0; i<m; i++) {
			cout<<"I["<<i<<"] ";
			cin>>B[i];
		}
		loop21:
		cout<<endl<<"Нажмите \'s\' чтобы сохранить результат, или \'r\' чтобы редактировать данные";
		loop20:
		ch=getch();
		if (ch=='r'){
			cout<<endl<<endl<<"Введите номер I'той вершины и новое значение: ";
			cin>>i>>s;
			B[i]=s;
			cout<<endl;
			goto loop21;
		}
		if (ch=='s'){
			out<<k<<endl;	//Запись кол-ва критериев
			out<<n<<" "<<m<<endl;	//Запись кол-ва вершин типа L R и I
			for (i=0; i<m; i++) out<<B[i]<<" ";	//Запись значений всех вершин типа I
			out<<endl;
			for (p=0; p<k; p++) for (i=0; i<n; i++) for (j=0; j<n; j++) for (q=0; q<m; q++) out<<A[i][j][q][p]<<" ";	//Запись весов ребер
			return 0;
		}
		goto loop20;
	}
	goto loop;
}
