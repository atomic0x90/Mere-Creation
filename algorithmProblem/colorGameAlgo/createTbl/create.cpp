#include <iostream>
#include <fstream>
using namespace std;

ofstream fout("createTbl.out");

int main(){
	int mat;
	int start,end;
	cout<<"mat : ";
	cin>>mat;
	cout<<"start : ";
	cin>>start;
	cout<<"end : ";
	cin>>end;

	for(int i = start;i <= end;i++){
		fout<<"\t//Game Lock table "<<mat<<"-"<<mat<<"-"<<i<<endl;
		fout<<"sqlCreateTbl = \"CREATE TABLE IF NOT EXISTS GameLock"<<mat<<"_"<<mat<<"_"<<i<<" (\" +"<<endl;
		fout<<"\t\"Lock\" + \"INTEGER NOT NULL)\";"<<endl;
		fout<<"sqliteDB.execSQL(sqlCreateTbl);"<<endl<<endl;
		fout<<"sqlQuery = \"SELECT * FROM GameLock"<<mat<<"_"<<mat<<"_"<<i<<"\";"<<endl;
		fout<<"cursor = null;"<<endl;
		fout<<"cursor = sqliteDB.rawQuery(sqlQuery,null);"<<endl;
		fout<<"try {"<<endl;
		fout<<"\tif(!cursor.moveToNext()){"<<endl;
		fout<<"\t\tString sqlInsert = \"INSERT INTO GameLock"<<mat<<"_"<<mat<<"_"<<i<<"\" + \"(Lock)\" + \"VALUES (\" + 1 + \");\";"<<endl;
		fout<<"\t\tsqliteDB.execSQL(sqlInsert);"<<endl;
		fout<<"\t}"<<endl;
		fout<<"}catch ( Exception e){"<<endl;
		fout<<"\tSystem.out.println(\"Error GameLock tbl : \" + e);"<<endl;
		fout<<"}"<<endl<<endl;
	}
	return 0;
}
