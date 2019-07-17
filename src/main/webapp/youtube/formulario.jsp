<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

	<h1>Formulario</h1>
	<form>

      <div class="form-group row">
        <label for="colFormLabelLg" class="col-sm-3 col-form-label col-form-label-lg">Titulo</label>
        <div class="col-sm-4">
          <input type="text" class="form-control form-control-lg" id="titulo"
            placeholder="Introduce el título del video">
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelLg" class="col-sm-3 col-form-label col-form-label-lg">Codigo</label>
        <div class="col-sm-4">
          <input type="text" class="form-control form-control-lg" id="producto" placeholder="Introduce el código del video">
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelLg" class="col-sm-3 col-form-label col-form-label-lg">Reproducciones</label>
        <div class="col-sm-4">
          <input type="number" class="form-control form-control-lg" min="0" id="reproducciones" placeholder="Introduce número de reproducciones">
        </div>
      </div>
 
      <div class="form-group row">
        <button type="submit" class="btn btn-primary mb-2">Guardar</button>
      </div>
    </form>

	
<%@include file="../includes/footer.jsp" %>