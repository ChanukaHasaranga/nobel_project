
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:lottie/lottie.dart';
import 'package:nobel_project/nobelcart.dart';
import 'package:percent_indicator/linear_percent_indicator.dart';


class profilepage extends StatefulWidget {
  const profilepage({super.key});

  @override
  State<profilepage> createState() => _profilepageState();
}

class _profilepageState extends State<profilepage> {

double nobelcount=00;
String img="assetss/logo1.png";
int limit=0;
String counted="";
double x=0;
int endcount=999;
int nextcount=0;
String frame="assetss/nononbel.json";
double precentage=0;
Color bcolor=const Color.fromARGB(255, 107, 107, 107);
Color barcolor=Colors.white;


void initState() {
    super.initState();
    updateCounted();
  }

    void updateCounted() {
    nobelcount=3400;
    setState(() {
      if (500<= nobelcount && nobelcount<= 1499) {
        counted = "assetss/pawnbatch.png";
        img="assetss/pawnbatch.png";
         limit=500;
         x=nobelcount-limit;
         endcount=1499;
         nextcount=3999;
         frame='assetss/test.json';
         precentage=nobelcount/endcount;
         bcolor=Colors.green;
         barcolor=const Color.fromARGB(255, 25, 121, 29);

      } else if (1500<=nobelcount && nobelcount <=3999) {
        counted = "assetss/nonnobel.jpg";
          img="assetss/baronbatch.png";
         limit=1500;
         endcount=3999;
         nextcount=11999;
         frame="assetss/nononbel.json";
        precentage=nobelcount/endcount;
        bcolor=Colors.blue;
        barcolor=const Color.fromARGB(255, 3, 103, 186);


      } else if(4000<=nobelcount && nobelcount<=11999){
         counted = "assetss/baronbatch.png";
         img="assetss/knightbatch.png";
         limit=4000;
         endcount=11999;
         endcount=11999;
         nextcount=29999;
         frame='assetss/bishop.json'; 
         precentage=nobelcount/endcount;
         bcolor=Colors.purple;
         barcolor=const Color.fromARGB(255, 153, 0, 180);


       
      }
    });
  }

  @override
  Widget build(BuildContext context) {
 double height=MediaQuery.of(context).size.height;
 double width=MediaQuery.of(context).size.width;
updateCounted();

    return SafeArea(
      child: Scaffold(
        backgroundColor: Color.fromARGB(255, 39, 39, 39),
       appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 39, 39, 39),
        title: Text("My Noble",style: TextStyle(color: Colors.black,fontSize: width/20),),
        leading: IconButton(onPressed:() {
          
        }, icon:Icon(Icons.arrow_back_ios,color: Color.fromARGB(255, 86, 49, 1),size: width/20,)),
      
        actions: [
          IconButton(onPressed:() {
            
          }, icon:Icon(Icons.question_mark_rounded,size: width/20,color:Color.fromARGB(255, 86, 49, 1),)),
         IconButton(onPressed:() {
            
          }, icon:Icon(Icons.emoji_events,size:width/20,color:Color.fromARGB(255, 86, 49, 1),)),
      
      
        ],
        
       ),
       body: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [

            Padding(
              padding:  EdgeInsets.only(top: height/20,left: width/20,right: width/20),
              child: Container(
                width: double.infinity,
                decoration: BoxDecoration(
                  color: bcolor,
                  borderRadius: BorderRadius.circular(13),
                ),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceAround,
                        children: [
                          Column(
                            children: [
                              Text("Wohn",style: TextStyle(color: Colors.white,fontSize: width/14,fontWeight: FontWeight.bold),),
                        //           Container(
                        //     height: height/14,
                        //     width: width/2.7,
                           
                        //     decoration: BoxDecoration(
                        //   image: DecorationImage(image: AssetImage("$counted"),fit: BoxFit.contain)
                       
                        //  ),
                        //    ),
                
                            ],
                          ),
                              
                        Stack(
                          children: [
                            SizedBox(
                              height: height/6,
                              width: width/3,
                              child: LottieBuilder.asset(frame),
                            ),
                            Positioned(
                              top: height/42,
                              left: width/14,
                              child: Container(
                                height: height/9,
                                width: width/5,
                                decoration: BoxDecoration(
                                  image: DecorationImage(image: AssetImage("assetss/user.png"),fit: BoxFit.contain)
                                ),
                              ),
                            )
                          ],
                        )
                         
                          
                        ],
                      ),
                       Padding(
                  padding:  EdgeInsets.only(top:height/76 ,bottom: height/60),
                  child: Container(
                  width: double.infinity,
                  padding: EdgeInsets.symmetric(horizontal: width/30),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Icon(Icons.money, color: Color.fromARGB(255, 255, 255, 255), size: width / 25),
                      SizedBox(width: width/100,),
                      Text("$limit",style: TextStyle(color: Color.fromARGB(255, 255, 255, 255),fontSize: width/25),),
                      SizedBox(width: width/100),
                      Expanded(
                        child: LinearPercentIndicator(
                          lineHeight: height/70,
                          animation: true,
                          progressColor: barcolor,
                          percent: precentage,
                          barRadius: Radius.circular(55),
                          
                     
                          backgroundColor: Color.fromARGB(108, 158, 158, 158),
                        ),
                      ),
                                          SizedBox(width: width/100),
                  Container(
                    height: height/15,
                    width: width/7,
                    decoration: BoxDecoration(
                      image: DecorationImage(image: AssetImage("$img"),fit: BoxFit.contain)
                    ),
                  ),
                      SizedBox(width: width/100,),
                      Text("$endcount",style: TextStyle(color: Color.fromARGB(255, 255, 255, 255),fontSize: width/25),),
                    ],
                  ),
                                ),
                )
                
                  ],
                ),
              ),
            ),
       
   
          //  Padding(
          //    padding:  EdgeInsets.only(top:height/30,bottom: height/70),
          //    child: Text("John",style: TextStyle(color: const Color.fromARGB(255, 255, 255, 255),fontSize: width/15,fontWeight: FontWeight.bold),),
          //  ),
       
      //  Padding(
      //    padding:  EdgeInsets.only(top:height/30,left: width/20,right: width/20),
      //    child: Row(
      //     mainAxisAlignment: MainAxisAlignment.spaceBetween,
      //     children: [
      //       Container(
      //         child: Column(
      //           mainAxisAlignment: MainAxisAlignment.start,
      //           crossAxisAlignment: CrossAxisAlignment.center,
      //           children: [
      //             Padding(
      //               padding:  EdgeInsets.only(top:height/55 ),
      //               child: Text("NOBEL LIMIT",style: TextStyle(fontSize: width/20,color:Colors.white,fontWeight: FontWeight.bold),),


      //             ),
      //               Padding(
      //               padding:  EdgeInsets.only(top: height/35),
      //               child: Text("$limit - $endcount",style: TextStyle(fontSize: width/25,color:Colors.white,fontWeight: FontWeight.bold),),
      //             ),
      //                               SizedBox(height: height/40,)

                  
      //           ],
      //         ),
      //         width: width/2.3,
      //         decoration: BoxDecoration(
      //           color: const Color.fromARGB(255, 46, 32, 27),
      //           borderRadius: BorderRadius.circular(33)
      //         ),
      //       ),

            

      //              Container(
      //  child: Column(
      //           mainAxisAlignment: MainAxisAlignment.start,
      //           crossAxisAlignment: CrossAxisAlignment.center,
      //           children: [
      //             Padding(
      //               padding:  EdgeInsets.only(top:height/55 ),
      //               child: Text("NEXT NOBEL",style: TextStyle(fontSize: width/20,color:Colors.white,fontWeight: FontWeight.bold),),
      //             ),
      //             Padding(
      //               padding:  EdgeInsets.only(top: height/35),
      //               child: Text("${endcount+1} - $nextcount",style: TextStyle(fontSize: width/25,color:Colors.white,fontWeight: FontWeight.bold),),
      //             ),
      //             SizedBox(height: height/40,)
                  
      //           ],
      //         ),

      //         width: width/2.3,
      //         decoration: BoxDecoration(
      //           color: const Color.fromARGB(255, 46, 32, 27),
      //           borderRadius: BorderRadius.circular(33)
      //         ),

              
      //       )
      //     ],
      //    ),
      //  ),



        
                Padding(
                  padding:  EdgeInsets.only(top: height/34,left: width/25,right: width/25),
                  child: Container(
                    child: SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Row(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        mainAxisAlignment: MainAxisAlignment.spaceAround,
                        children: [
                            nobelcart(img: ["assetss/logo1.png","assetss/pawnbatch.png"], name: 'Pawn',),
                            SizedBox(width: width/25,),
                            nobelcart(img: ["assetss/baron.png","assetss/baronbatch.png"], name: 'Rook',),
                            SizedBox(width: width/25,),
                            nobelcart(img: ["assetss/knight.png","assetss/knightbatch.png"], name: "Knight"),
                            SizedBox(width: width/25,),
                            nobelcart(img: ["assetss/bishop.png","assetss/bishopbatch.png"], name: 'Bishop',),

                             
                             
                        ],
                      
                      ),
                    ),
                  ),
                )
       
            
       
           
       
       
          ],
        ),
       ),
      ),
    );
  }
}