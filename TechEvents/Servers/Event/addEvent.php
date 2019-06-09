<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$titre=$_REQUEST['titre'];
$description=$_REQUEST['description'];
$capacitemax=$_REQUEST['capacitemax'];
$capacitemin=$_REQUEST['capacitemin'];
$dateevent=$_REQUEST['dateevent'];
$duree=$_REQUEST['duree'];
$photoPath=$_REQUEST['photoPath'];


require_once('connect.php'); 
      $query_search = "insert into evenement  (titre,description,capacitemax,capacitemin,dateevent,duree,idsponsor,idloc,photoPath,statut) 
	  VALUES ('$titre', '$description' ,$capacitemax,$capacitemin, $dateevent,$duree,1,1,$photoPath,'Disponible') ";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>
