# Family-Tree

@author : Janardhanan V S


Requirements:
-------------

JRE 1.8+
Maven
JAVA_HOME should be set in path



Assumptions Made:
------------------

1) No two members exists with the same name.
2) The family tree denotes the direct descendents of 'King Shan'. For other member such as wifes of sons, their direct relations are not provided, as it will makeup another family tree
3) The default family tree given with the problem, is preloaded. Addition of new family members is not provided, to keep it simple.
4) Only Male and Female genders are currently supported.



Possible Improvements:
----------------------

1) Can use a fixed size cache, to speed up the frequent reads.



Steps to Run:
-------------

There a build scripts available for building and running the project.

Else, it is as simple as:

	'java -jar family-tree.jar'
	
	
	
Sample Input / Output
---------------------

----- Select a number ----- 
1. Find relative
2. List avaiable relations
3. Exit

> 1

Enter Name (Case Sensitive)

> Drita

Enter Relation (Case Sensitive)

> cousins

---------------------- Output ----------------------

[ Vila, Chika, Saayan, Satvy, Savya,  ]

----------------------------------------------------	
	
	
	
	
Note: 
-----
1) Before trying to run build scripts, kindly give executable permission for the scripts.
2) Kindly refer to the data set, since input is case sensitive.
3) Have included few test cases. The rest of the test cases will be updated shortly, due to time constraints.

