import 'package:flutter/foundation.dart';
import 'package:nobel_project/Service/database_services.dart';
import 'package:nobel_project/models/database.dart';


class databasedata extends ChangeNotifier{

List<databases> Databases =[];

void adddata(String datatitle) async{

databases database =await DatabaseServices.adddata(datatitle);
Databases.add(database);
notifyListeners();


}



}