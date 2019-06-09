<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$idEvent=$_REQUEST['idEvent'];
$titre=$_REQUEST['titre'];
$description=$_REQUEST['description'];
$capacitemax=$_REQUEST['capacitemax'];
$capacitemin=$_REQUEST['capacitemin'];
$duree=$_REQUEST['duree'];
$statut=$_REQUEST['statut'];
$dateevent=$_REQUEST['dateevent'];

require_once('connect.php'); 
      $query_search = "update evenement set titre = '$titre', description = '$description', capacitemax = $capacitemax ,
	  capacitemin = $capacitemin  ,duree = $duree , statut = '$statut' , dateevent = $dateevent where idEvent = $idEvent ";
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>
