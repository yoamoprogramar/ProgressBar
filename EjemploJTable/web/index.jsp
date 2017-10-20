<html>
    <head>
        <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link href="${pageContext.request.contextPath}/js/jtable.2.3.1/themes/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.jtable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.hotkeys-0.7.9.min.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/js/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/validationEngine/jquery.validationEngine.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/validationEngine/jquery.validationEngine-es.js"></script>
    </head>
    <body>

        <div id="Usuarios" style="margin:auto;width:95%;">
            <div class="filtering">
                Buscar <input type="text" id="buscar">
            </div>	
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#Usuarios').jtable({
                    title: 'Usuarios',
                    paging: true,
                    pageSize: 5,
                    sorting: true,
                    defaultSorting: 'Nombre ASC',
                    toolbarsearch: true,
                    actions: {
                        listAction: '${pageContext.request.contextPath}/Control?action=list',
                        createAction: '${pageContext.request.contextPath}/Control?action=create',
                        updateAction: '${pageContext.request.contextPath}/Control?action=update',
                        deleteAction: '${pageContext.request.contextPath}/Control?action=delete'
                    },
                    fields: {
                        IdUsuario: {
                            key: true,
                            create: false,
                            edit: false,
                            list: false
                        },
                        Usuario: {
                            title: 'Usuario '
                        },
                        Password: {
                            title: 'Password'
                        },
                        Nombre: {
                            title: 'Nombre'
                        }
                    }
                });

                $('#Usuarios').jtable('load');
            });
        </script>

    </body>
</html>
