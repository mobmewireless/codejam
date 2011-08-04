<?php

	// Include Twitter Search API wrapper class
	require("./lib/TwitterSearch.php");
		
		
	$id = ""; // Id of the last recived tweet
	$file = fopen("id.txt", "r+"); // The last rquests tweet id is stored in id.txt
	$id = $id.fgets($file); // Read the last tweet id to $id
	
	$search = new TwitterSearch('"i love you"'); // Initialize search class with query "i love you"
	$search->user_agent = 'phptwittersearch:emotion@gmail.com'; // Set the user agent, something twitter API would like us to set!
	
	if($id!=0) // well if id!=0, that is the initial case or first run get just two tweets to start the timeline
		$results = $search->since($id)->rpp(100)->results(); // Get a a max of 100 tweets, max is set by twitter :(
	else $results = $search->rpp(2)->results(); // Just get 2 tweets just to get the id of the tweet which ca be used in futeure request 
	
	$id = $results[0]->id_str; // get the id of the first tweet ie., latest tweet

	
	$file = fopen("id.txt", "w+"); 
	fwrite($file,$id); //write the id to file id.txt, so we can retieve the id in next request
	fclose($file); 
	
	// Set the JSON header
	header("Content-type: text/json");

	// The x value is the current JavaScript time, which is the Unix time multiplied by 1000.
	$x = time() * 1000; // values for x-axis of the graph
	$y = sizeof($results); // sizeof($results) gives us the number of tweet results returned or the number tweets with "i love you"

	$ret = array($x, $y); // create an array with x and y values for grap
	echo json_encode($ret); // json encode the php array and echo it. Tada!

	

