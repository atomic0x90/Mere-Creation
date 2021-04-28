#include <iostream>
#include <fstream>

using namespace std;

ofstream fout("load5.out");

int main(){
	for(int i = 1;i < 51;i++)
	{
		fout<<"private void loadGameLock"<<i<<"(){"<<endl;
		fout<<"\tif(sqliteDB != null){"<<endl;
		fout<<"\t\tString sqlQuery = \"SELECT * FROM GameLock5_5_"<<i<<"\";"<<endl;
		fout<<"\t\tCursor cursor = null;"<<endl;
		fout<<"\t\tcursor = sqliteDB.rawQuery(sqlQuery,null);"<<endl;
		fout<<"\t\tif(cursor.moveToNext()){"<<endl;
		fout<<"\t\t\tlock"<<i<<" = cursor.getInt(0);"<<endl;
		fout<<"\t\t}"<<endl;
		fout<<"\t}"<<endl;
		fout<<"}"<<endl<<endl;
		
	}
	return 0;
}
