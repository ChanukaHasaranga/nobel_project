class databases{
final int id;
final String name;
final String address;
final int count;
bool done;

databases({

required this.id,
required this.name,
required this.address,
required this.count,
this.done=false,

});

factory databases.fromMap(Map<String, dynamic> databasesMap){

return databases(
  id: databasesMap['id'], 
  name: databasesMap['name'], 
  address: databasesMap['address'],
  count:databasesMap['count']
  
  );



}

void toggle(){
  done=!done;
}

}