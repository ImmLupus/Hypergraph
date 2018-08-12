#include <iostream>
#include <ctime>
#include <stdlib.h>
#include <fstream>
using namespace std;
main(){
	srand(time(NULL));
	ofstream out("input.txt");
	int k,n,m;
	cout<<"Kriterii: "; cin>>k;
	out<<k<<endl;
	cout<<"L R: "; cin>>n;
	cout<<"I: "; cin>>m;
	out<<n<<" "<<m<<endl;
	int I[m];
	for (int i=0; i<m; i++) {cout<<"I["<<i<<"]: "; cin>>I[i];}
	for (int i=0; i<m; i++) out<<I[i]<<" ";
	out<<endl;
	for (int p=0; p<k; p++) for (int i=0; i<n; i++) for (int j=0; j<n; j++) for (int q=0; q<m; q++) out<<rand()%999+1<<" ";
}
