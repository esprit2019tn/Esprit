<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$sujet=$_REQUEST['sujet'];
$text=$_REQUEST['text'];
$iduser=$_REQUEST['iduser'];
$idevent=$_REQUEST['idevent'];




require_once('..\connect.php'); 
      $query_search = "INSERT INTO `reclamation` (`textReclam`, `sujetReclam`, 	idEvent , idUser ) VALUES ( '$text' ,'$sujet' ,$idevent,$iduser  ) ";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>