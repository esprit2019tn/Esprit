<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$iduser=$_REQUEST['iduser'];
$idevent=$_REQUEST['idevent'];

require_once('connect.php'); 
      $query_search = "SELECT * FROM reservation where idEvent=$idevent and idUser = $iduser  ;";  
      $jsontext = "[";
	   $a = 0 ;
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
			foreach($stmt1->fetchAll() as $row) {
					$a = 1 ;
				$jsontext .="{";
				foreach($row as $key => $value) {
	    			$jsontext .= '"'.addslashes($key).'": "'.addslashes($value).'",';
					}
					$jsontext = substr_replace($jsontext, '', -1);
					$jsontext .="},";
	}
	$jsontext = substr_replace($jsontext, '', -1);
	$jsontext .= "]";
	if($a == 0){
		//echo "fer" ;
		$jsontext = "[]";
	}
	echo $jsontext;

?>
