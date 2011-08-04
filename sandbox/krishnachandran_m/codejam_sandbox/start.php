<html>
    <head>
        <title>codejam</title>
        <script type="text/javascript" src="scripts/jquery.js"></script>
        <script type="text/javascript" src="scripts/my_script.js"></script>
        <link type="text/css" href="scripts/style.css" rel="stylesheet" />
    </head>
    <body>
        <input type="text" id="txtId" value="60" />
        <div style="width: 100%; height: 110px;">
            <span>
                Command
                <img id="processing" src="scripts/loading.gif" style="display: none;"/>
                <button id="process" type="button" class="ui-button" onclick="return process();" role="button" style="float: right;">
                    <span class="ui-button-text">Process</span>
                </button>
            </span>
            <form id="cmd" onsubmit="return false"><input type="text" class="cmdbox" id="cmdbox" name="cmdbox" onchange="process();"/></form>
        </div>
        <div>
            <textarea class="outbox" id="outbox" readonly="readonly"></textarea>
        </div>
        COMMANDS<br/>list | pwd | cat | rm | touch | time | help
    </body>
</html>