<?php
//http://icons.iconarchive.com/icons/deleket/scrap/256/Aqua-Ball-Red-icon.png
//http://icons.iconarchive.com/icons/deleket/scrap/256/Aqua-Ball-Green-icon.png
?>
<html>
    <head>
        <title>codejam</title>
        <script type="text/javascript" src="scripts/jquery.js"></script>
        <script type="text/javascript" src="scripts/my_script.js"></script>
        <link type="text/css" href="scripts/style.css" rel="stylesheet" />
    </head>
    <body>
        <table align="center">
            <tr>
                <th>Image 1</th>
                <th>Image 2</th>
            </tr>
            <tr align="center">
            <form id="imname" onsubmit="return false">
                <td><input type="text" id="image1" name="image1" class="imagename" onchange="change(this)" value="http://www.infobarrel.com/media/image/37307.png"/></td>
                <td><input type="text" id="image2" name="image2" class="imagename" onchange="change(this)" value="http://www.freewebs.com/peacemakers63231997/photos/Soccer/Soccer_ball6.png"/></td>
            </form>
        </tr>
        <tr align="center">
            <td><img src="http://www.infobarrel.com/media/image/37307.png" id="image1prev" class="preview"/></td>
            <td><img src="http://www.freewebs.com/peacemakers63231997/photos/Soccer/Soccer_ball6.png" id="image2prev" class="preview"/></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <img id="processing" src="scripts/loading.gif" style="display: none;"/>
                <button id="compare" type="button" class="ui-button" onclick="compare();" role="button">
                    <span class="ui-button-text">Compare</span>
                </button>
                <div id="result"></div>
            </td>
        </tr>
    </table>
</body>
</html>