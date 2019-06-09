<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$dateActu=$_REQUEST['dateActu'];
$descActu=$_REQUEST['descActu'];
$idEvent=$_REQUEST['idEvent'];

require_once('connect.php'); 
      $query_search = "INSERT INTO `actualite` (`numActu`, `dateActu`,`descActu`, `idEvent`) VALUES (NULL, '$dateActu', '$descActu', '$idEvent') ";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
      echo $query_search;
?>
