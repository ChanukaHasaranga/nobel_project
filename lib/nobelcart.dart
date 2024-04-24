import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class nobelcart extends StatefulWidget {
List img;
String name;



   nobelcart({
    
    required this.img,
    required this.name,

    super.key});

  @override
  State<nobelcart> createState() => _nobelcartState();
}

class _nobelcartState extends State<nobelcart> {
  @override
  Widget build(BuildContext context) {
 double height=MediaQuery.of(context).size.height;
 double width=MediaQuery.of(context).size.width;
   List img=widget.img;

    return Container(
      width: width/1.1,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(22),
        color: Colors.transparent,
        border: Border.all(color: Colors.brown)
      ),
       child: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Container(
            width: width/1.5,

            decoration: BoxDecoration(
              color: Colors.brown,
              borderRadius: BorderRadius.only(
                bottomLeft: Radius.circular(23),
                bottomRight: Radius.circular(23)
              )
            ),
            child: Center(child: Padding(
              padding: const EdgeInsets.all(14.0),
              child: Text(widget.name,style: TextStyle(color: Colors.white,fontSize: width/24),),
            )),
          ),

          Container(
            height: height/6,
            width: double.infinity,
            child: GridView.builder(
              itemCount: img.length,
              
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3,
              mainAxisExtent: 65,
              ), 
              
              itemBuilder:(context, index) {
                
                return Padding(
                  padding:  EdgeInsets.only(top: height/30,left: width/25,right: width/25),
                  child: Container(
                                                                                     
                   decoration: BoxDecoration(
                    image: DecorationImage(image: AssetImage(img[index]),fit: BoxFit.contain)
                   ),
                  ),
                );
              },
              
              
              ),
          )

        ],
       ),
    );
  }
}