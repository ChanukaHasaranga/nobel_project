import 'package:flutter/material.dart';
import 'package:nobel_project/profilepage.dart';

void main(){

runApp(myapp());



}
class myapp extends StatelessWidget {
  const myapp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
  title: "Nobel_Project",
  home: profilepage(),
  
  theme: ThemeData(brightness: Brightness.light),
    );
  }
}