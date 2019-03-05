package com.guigu.service.examination;

import com.guigu.domain.eduoffice.LayUiPageInfo;

public interface IExamApplyService {
	LayUiPageInfo queryFullApply(int page,int limit);
}
