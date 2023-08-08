Annotations:

1) Annotation is the meta data to class or interface or method and etc.

2) In built java provided annotations are,
   a) override          -> assure you that method is overidden from parent.
   b) supressWarning    -> just supress warnings in source code.
   c) deprecated        -> inform to developer that method will not available in future releases
   
3) Below code will not create object to Annotated class.

   Method method  = Annotated.class.getMethod("test", null);

   So without creating object to class itself, get to know that metadata of class or method.

4) Rules for Annotation creation:

	a) Method should not have any throws clauses
	b) Method should return one of the following: primitive data types, String, Class, enum or array of these data types.
	c) Method should not have any parameter.
	d) We should attach @ just before interface keyword to define annotation.
	e) It may assign a default value to the method. 
	
5) Built-in Annotations:
   
   @Target: It indicates, where custom annotation is to be used.
   
	   java.lang.annotation.ElementType is enum, which should be declared part of @Target annotation.
	   
	   ElementType.Type      	 -> class or interface or enum
	   ElementType.Method            -> Method with
	   ElementType.Contructor        -> Contructor with
	   ElementType.Field             -> Instance varibale with 
	   ElementType.PARAMETER 	     -> Parameter with.
	   ElementType.ANNOTATION_TYPE   -> annotation creation itself  (ex: @target)
	   
	 @Retention: an annotation is used to specify to what level annotation will be available.
	 
	  RetentionPolicy.SOURCE        -> only source level (ex:- @supressWarning)
	  RetentionPolicy.COMPILE       -> At compile level  (ex:- @override)
	  RetentionPolicy.RUNTIME       -> At compiler and jvm level.
	  
6) Usage of annotation is same as varibale assignment not declaration
   declaration means variable already declared in the annotation creation.
