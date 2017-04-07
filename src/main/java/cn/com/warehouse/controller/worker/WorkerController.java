package cn.com.warehouse.controller.worker;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.warehouse.entity.dispatch.DispatchEntity;
import cn.com.warehouse.entity.worker.WorkerEntity;
import cn.com.warehouse.service.worker.WorkerService;
import cn.com.warehouse.util.Paging;

/**
 * @author 员工控制层
 *
 */
@Controller
public class WorkerController {

	@Resource
	private WorkerService workerService;

	/**
	 * 跳转到员工列表
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/workerList", method = RequestMethod.GET)
	public String workerList(Model model, Paging<WorkerEntity> page) {
		model.addAttribute("page", workerService.getWorkerList(page));
		return "worker/worker_list";
	}

	/**
	 * 跳转到添加员工
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/createWorker", method = RequestMethod.GET)
	public String createPage(Model model) {
		return "worker/worker_create";
	}

	/**
	 * 跳转到编辑员工
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateWorker", method = RequestMethod.GET)
	public String updatePage(Model model, @RequestParam int workerNumber) {
		model.addAttribute("worker", workerService.getWorkerById(workerNumber));
		return "worker/worker_update";
	}

	/**
	 * 跳转到员工详细页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/workerDetail", method = RequestMethod.GET)
	public String workerDetail(Model model, @RequestParam int workerNumber) {
		model.addAttribute("worker", workerService.getWorkerById(workerNumber));
		return "worker/worker_detail";
	}

	/**
	 * 新增员工
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/createWorker", method = RequestMethod.POST)
	public String createWorker(WorkerEntity worker) {
		workerService.createWorker(worker);
		return "redirect:/workerList";
	}

	/**
	 * 编辑员工
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/updateWorker", method = RequestMethod.POST)
	public String updateWorker(WorkerEntity worker) {
		workerService.updateWorker(worker);
		return "redirect:/workerList";
	}

	/**
	 * 删除员工
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/deleteWorker", method = RequestMethod.GET)
	public String deleteWorker(long workerNumber) {
		workerService.deleteWorker(workerNumber);
		return "redirect:/workerList";
	}

	/**
	 * 校验员工名称是否存在
	 * 
	 * @return boolean
	 */
	@RequestMapping(value = "/checkWorkerNumber", method = RequestMethod.POST)
	@ResponseBody
	private boolean checkWorkerNumber(String workerNumber) {
		return workerService.checkWorkerNumber(workerNumber);
	}

	/**
	 * 派遣员工
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/sendWorker", method = RequestMethod.POST)
	public String sendWorker(DispatchEntity dispatch) {
		workerService.createDispatch(dispatch);
		return "redirect:/workerList";
	}

	/**
	 * 根据工号查看派遣详细
	 * 
	 * @return WorkerEntity
	 */
	@RequestMapping(value = "/dispatchList", method = RequestMethod.GET)
	public String dispatchList(Model model, Paging<DispatchEntity> page, String workerNumber) {
		model.addAttribute("page", workerService.dispatchList(page, workerNumber));
		return "worker/dispatch_list";
	}
}
