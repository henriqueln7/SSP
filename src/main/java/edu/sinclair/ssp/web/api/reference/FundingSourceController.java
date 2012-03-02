package edu.sinclair.ssp.web.api.reference;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.sinclair.ssp.model.reference.FundingSource;
import edu.sinclair.ssp.model.transferobject.Form;
import edu.sinclair.ssp.service.reference.FundingSourceService;

@PreAuthorize("hasRole('ROLE_USER')")
@Controller
@RequestMapping("/reference/fundingSource")
public class FundingSourceController extends ReferenceController<FundingSource>{

	//private static final Logger logger = LoggerFactory.getLogger(FundingSourceController.class);

	@Autowired
	private FundingSourceService service;
	
	@Override
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<FundingSource> getAll() throws Exception {
		return service.getAll();
	}
	
	@Override
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody FundingSource get(@PathVariable UUID id) throws Exception {
		return service.get(id);
	}
	
	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody FundingSource save(@Valid FundingSource obj) throws Exception {
		return service.save(obj);
	}

	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public boolean delete(@PathVariable UUID id) throws Exception {
		service.delete(id);
		return true;
	}

	@Override
	public Form<FundingSource> create() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
