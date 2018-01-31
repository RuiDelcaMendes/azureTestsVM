package service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.olingo.odata2.api.edm.EdmEntityContainer;
import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.exception.ODataNotFoundException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.NavigationSegment;
import org.apache.olingo.odata2.api.uri.info.GetComplexPropertyUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetSimplePropertyUriInfo;
import org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext;
import org.apache.olingo.odata2.processor.core.jpa.ODataJPAProcessorDefault;
import org.apache.olingo.odata2.processor.core.jpa.ODataJPAResponseBuilder;

public class CustomODataJPAProcessor extends ODataJPAProcessorDefault {

	public CustomODataJPAProcessor(ODataJPAContext oDataJPAContext) {
		super(oDataJPAContext);
	}

	@Override
	public ODataResponse readEntitySet(GetEntitySetUriInfo uriInfo, String contentType) throws ODataException {
		
		List<Object> jpaEntities = jpaProcessor.process(uriInfo);
		
		
	    ODataResponse oDataResponse =
	            ODataJPAResponseBuilder.build(jpaEntities, uriInfo, contentType, oDataJPAContext);
	    
	    EntityManager em = oDataJPAContext.getEntityManager();
	    
   
	    return oDataResponse;
	}

/*	  private Object retrieveData(final EdmEntitySet startEntitySet, final List<KeyPredicate> keyPredicates,
		      final EdmFunctionImport functionImport, final Map<String, Object> functionImportParameters,
		      final List<NavigationSegment> navigationSegments) throws ODataException {
		    Object data;
		    final Map<String, Object> keys = mapKey(keyPredicates);

		    ODataContext context = getContext();
		    final int timingHandle = context.startRuntimeMeasurement(getClass().getSimpleName(), "retrieveData");

		    try {
		      data = functionImport == null ?
		          keys.isEmpty() ?
		              dataSource.readData(startEntitySet) : dataSource.readData(startEntitySet, keys) :
		          dataSource.readData(functionImport, functionImportParameters, keys);

		      EdmEntitySet currentEntitySet =
		          functionImport == null ? startEntitySet : functionImport.getEntitySet();
		      for (NavigationSegment navigationSegment : navigationSegments) {
		        data = dataSource.readRelatedData(
		            currentEntitySet,
		            data,
		            navigationSegment.getEntitySet(),
		            mapKey(navigationSegment.getKeyPredicates()));
		        currentEntitySet = navigationSegment.getEntitySet();
		      }
		    } finally {
		      context.stopRuntimeMeasurement(timingHandle);
		    }
		    return data;
		  }
*/	
	@Override
	  public ODataResponse readEntityComplexProperty(final GetComplexPropertyUriInfo uriInfo, final String contentType)
	      throws ODataException {
	    /*
		Object data = retrieveData(
	        uriInfo.getStartEntitySet(),
	        uriInfo.getKeyPredicates(),
	        uriInfo.getFunctionImport(),
	        null,
	        //mapFunctionParameters(uriInfo.getFunctionImportParameters()),
	        uriInfo.getNavigationSegments());

	    // if (!appliesFilter(data, uriInfo.getFilter()))
	    if (data == null) {
	      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
	    }

	    final List<EdmProperty> propertyPath = uriInfo.getPropertyPath();
	    final EdmProperty property = propertyPath.get(propertyPath.size() - 1);
	    final Object value = property.isSimple() ?
	        property.getMapping() == null || property.getMapping().getMediaResourceMimeTypeKey() == null ?
	            getPropertyValue(data, propertyPath) : getSimpleTypeValueMap(data, propertyPath) :
	        getStructuralTypeValueMap(getPropertyValue(data, propertyPath), (EdmStructuralType) property.getType());

	    ODataContext context = getContext();
	    final int timingHandle = context.startRuntimeMeasurement("EntityProvider", "writeProperty");

	    final ODataResponse response = EntityProvider.writeProperty(contentType, property, value);

	    context.stopRuntimeMeasurement(timingHandle);

	    return ODataResponse.fromResponse(response).eTag(constructETag(uriInfo.getTargetEntitySet(), data)).build();
	    */
		return null;
	  }
	
	@Override
	public ODataResponse readEntitySimpleProperty(GetSimplePropertyUriInfo uriInfo, String contentType)
			throws ODataException {
		List<KeyPredicate> lk = uriInfo.getKeyPredicates();
		EdmEntityContainer ec = uriInfo.getEntityContainer();
		List<EdmProperty> lp =  uriInfo.getPropertyPath();
		 return readEntityComplexProperty((GetComplexPropertyUriInfo) uriInfo, contentType);
	}

	@Override
	public ODataResponse readEntity(GetEntityUriInfo uriParserResultView, String contentType) throws ODataException {
		// TODO Auto-generated method stub
		return super.readEntity(uriParserResultView, contentType);
	}

	
	
}
