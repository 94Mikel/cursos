<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
                  method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-group row mb-3">
                        <label class="col-sm-2 col-form-label" for="nombre">Nombre</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="nombre" required/>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <label class="col-sm-2 col-form-label" for="nombre">Apellido</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="apellido" required/>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <label class="col-sm-2 col-form-label" for="nombre">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" required/>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <label class="col-sm-2 col-form-label" for="nombre">Telefono</label>
                        <div class="col-sm-10">
                            <input type="tel" class="form-control" name="telefono" required/>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <label class="col-sm-2 col-form-label" for="nombre">Saldo</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" name="saldo" required step="any"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>

            </form> 

        </div>
    </div>
</div>
