package service;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.apache.olingo.odata2.api.batch.BatchHandler;
import org.apache.olingo.odata2.api.batch.BatchRequestPart;
import org.apache.olingo.odata2.api.batch.BatchResponsePart;
import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.edm.EdmEntityContainer;
import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderBatchProperties;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.exception.ODataNotFoundException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataRequest;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.NavigationSegment;
import org.apache.olingo.odata2.api.uri.PathInfo;
import org.apache.olingo.odata2.api.uri.UriInfo;
import org.apache.olingo.odata2.api.uri.info.GetComplexPropertyUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetCountUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetSimplePropertyUriInfo;
import org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext;
import org.apache.olingo.odata2.processor.core.jpa.ODataJPAProcessorDefault;
import org.apache.olingo.odata2.processor.core.jpa.ODataJPAResponseBuilder;
import org.hibernate.mapping.PersistentClass;

import model.Car;

public class CustomODataJPAProcessor extends ODataJPAProcessorDefault {

	public CustomODataJPAProcessor(ODataJPAContext oDataJPAContext) {
		super(oDataJPAContext);
	}

	@Override
	public ODataResponse readEntitySet(GetEntitySetUriInfo uriInfo, String contentType) throws ODataException {
		
		
		//uriInfo.getTop(); akiii
		
		
		List<Object> jpaEntities = jpaProcessor.process(uriInfo);
		
		//jpaEntities = jpaEntities.subList(uriInfo.getSkip(), uriInfo.getTop());

		ODataResponse oDataResponse = ODataJPAResponseBuilder.build(jpaEntities, uriInfo, contentType, oDataJPAContext);

		EntityManager em = oDataJPAContext.getEntityManager();

		return oDataResponse;
	}

	/*
	 * private Object retrieveData(final EdmEntitySet startEntitySet, final
	 * List<KeyPredicate> keyPredicates, final EdmFunctionImport functionImport,
	 * final Map<String, Object> functionImportParameters, final
	 * List<NavigationSegment> navigationSegments) throws ODataException { Object
	 * data; final Map<String, Object> keys = mapKey(keyPredicates);
	 * 
	 * ODataContext context = getContext(); final int timingHandle =
	 * context.startRuntimeMeasurement(getClass().getSimpleName(), "retrieveData");
	 * 
	 * try { data = functionImport == null ? keys.isEmpty() ?
	 * dataSource.readData(startEntitySet) : dataSource.readData(startEntitySet,
	 * keys) : dataSource.readData(functionImport, functionImportParameters, keys);
	 * 
	 * EdmEntitySet currentEntitySet = functionImport == null ? startEntitySet :
	 * functionImport.getEntitySet(); for (NavigationSegment navigationSegment :
	 * navigationSegments) { data = dataSource.readRelatedData( currentEntitySet,
	 * data, navigationSegment.getEntitySet(),
	 * mapKey(navigationSegment.getKeyPredicates())); currentEntitySet =
	 * navigationSegment.getEntitySet(); } } finally {
	 * context.stopRuntimeMeasurement(timingHandle); } return data; }
	 */
	@Override
	public ODataResponse readEntityComplexProperty(final GetComplexPropertyUriInfo uriInfo, final String contentType)
			throws ODataException {
		/*
		 * Object data = retrieveData( uriInfo.getStartEntitySet(),
		 * uriInfo.getKeyPredicates(), uriInfo.getFunctionImport(), null,
		 * //mapFunctionParameters(uriInfo.getFunctionImportParameters()),
		 * uriInfo.getNavigationSegments());
		 * 
		 * // if (!appliesFilter(data, uriInfo.getFilter())) if (data == null) { throw
		 * new ODataNotFoundException(ODataNotFoundException.ENTITY); }
		 * 
		 * final List<EdmProperty> propertyPath = uriInfo.getPropertyPath(); final
		 * EdmProperty property = propertyPath.get(propertyPath.size() - 1); final
		 * Object value = property.isSimple() ? property.getMapping() == null ||
		 * property.getMapping().getMediaResourceMimeTypeKey() == null ?
		 * getPropertyValue(data, propertyPath) : getSimpleTypeValueMap(data,
		 * propertyPath) : getStructuralTypeValueMap(getPropertyValue(data,
		 * propertyPath), (EdmStructuralType) property.getType());
		 * 
		 * ODataContext context = getContext(); final int timingHandle =
		 * context.startRuntimeMeasurement("EntityProvider", "writeProperty");
		 * 
		 * final ODataResponse response = EntityProvider.writeProperty(contentType,
		 * property, value);
		 * 
		 * context.stopRuntimeMeasurement(timingHandle);
		 * 
		 * return ODataResponse.fromResponse(response).eTag(constructETag(uriInfo.
		 * getTargetEntitySet(), data)).build();
		 */
		return null;
	}

	@Override
	public ODataResponse readEntitySimpleProperty(GetSimplePropertyUriInfo uriInfo, String contentType)
			throws ODataException {

		// List<KeyPredicate> lk = uriInfo.getKeyPredicates();
		// EdmEntityContainer ec = uriInfo.getEntityContainer();
		List<EdmProperty> lp = uriInfo.getPropertyPath();
		// UriInfo uri = (UriInfo)uriInfo;

		Object jpaEntity = jpaProcessor.process((GetEntityUriInfo) uriInfo);
		if (jpaEntity == null)
			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);

		try {
			return EntityProvider.writeProperty(contentType, lp.get(0),
					jpaEntity.getClass().getMethod("get" + lp.get(0).getName()).invoke(jpaEntity));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {

			throw new ODataNotFoundException(ODataNotFoundException.COMMON);
		}

	}

	@Override
	public ODataResponse executeBatch(BatchHandler handler, String contentType, InputStream content)
			throws ODataException {
		 List<BatchResponsePart> batchResponseParts = new ArrayList<BatchResponsePart>();
		  PathInfo pathInfo = getContext().getPathInfo();
		  EntityProviderBatchProperties batchProperties = EntityProviderBatchProperties.init().pathInfo(pathInfo).build();
		  List<BatchRequestPart> batchParts = EntityProvider.parseBatchRequest(contentType, content, batchProperties);
		  for (BatchRequestPart batchPart : batchParts) {
		    batchResponseParts.add(handler.handleBatchPart(batchPart));
		  }
		  return EntityProvider.writeBatchResponse(batchResponseParts);
	}

	@Override
	public BatchResponsePart executeChangeSet(BatchHandler handler, List<ODataRequest> requests) throws ODataException {
		 List<ODataResponse> responses = new ArrayList<ODataResponse>();
		    for (ODataRequest request : requests) {
		      ODataResponse response = handler.handleRequest(request);
		      if (response.getStatus().getStatusCode() >= HttpStatusCodes.BAD_REQUEST.getStatusCode()) {
		        // Rollback
		        List<ODataResponse> errorResponses = new ArrayList<ODataResponse>(1);
		        errorResponses.add(response);
		        return BatchResponsePart.responses(errorResponses).changeSet(false).build();
		      }
		      responses.add(response);
		    }
		    return BatchResponsePart.responses(responses).changeSet(true).build();
	}

	@Override
	public ODataResponse countEntitySet(GetEntitySetCountUriInfo uriParserResultView, String contentType)
			throws ODataException {
		return super.countEntitySet(uriParserResultView, contentType);
	}

	@Override
	public ODataResponse readEntity(GetEntityUriInfo uriParserResultView, String contentType) throws ODataException {
		// TODO Auto-generated method stub
		return super.readEntity(uriParserResultView, contentType);
	}

}
