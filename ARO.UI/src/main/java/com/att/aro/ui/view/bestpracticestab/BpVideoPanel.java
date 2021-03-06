/*
 *  Copyright 2015 AT&T
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.att.aro.ui.view.bestpracticestab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import com.att.aro.core.bestpractice.pojo.BestPracticeType;
import com.att.aro.core.pojo.AROTraceData;
import com.att.aro.ui.commonui.IARODiagnosticsOverviewRoute;


public class BpVideoPanel extends BpDetail {
	
	private static final long serialVersionUID = 1L;

	public BpVideoPanel(String title,
			IARODiagnosticsOverviewRoute diagnosticsOverviewRoute) {
		super(title, diagnosticsOverviewRoute);
		
		setBackground(new Color(238,238,238));
		int row = 0;

		addPanel(row++, new BpDetailItem("videoStall"       , BestPracticeType.VIDEO_STALL        ));
		addPanel(row++, new BpDetailItem("startUpDelay"     , BestPracticeType.STARTUP_DELAY      ));
		addPanel(row++, new BpDetailItem("bufferOccupancy"  , BestPracticeType.BUFFER_OCCUPANCY   ));
		addPanel(row++, new BpDetailItem("networkComparison", BestPracticeType.NETWORK_COMPARISON ));
		addPanel(row++, new BpDetailItem("tcpConnection"    , BestPracticeType.TCP_CONNECTION     ));
		addPanel(row++, new BpDetailItem("chunkSize"        , BestPracticeType.CHUNK_SIZE         ));
		addPanel(row++, new BpDetailItem("chunkPacing"      , BestPracticeType.CHUNK_PACING       ));
		addPanel(row++, new BpDetailItem("videoRedundancy"  , BestPracticeType.VIDEO_REDUNDANCY   ));
		
		fullPanel.add(dataPanel, BorderLayout.CENTER);
		fullPanel.add(detailPanel, BorderLayout.SOUTH);
		add(fullPanel);
		
		List<BestPracticeType> list = Arrays.asList(new BestPracticeType[]{   BestPracticeType.VIDEO_STALL
																			, BestPracticeType.STARTUP_DELAY
																			, BestPracticeType.BUFFER_OCCUPANCY
																			, BestPracticeType.NETWORK_COMPARISON
																			, BestPracticeType.TCP_CONNECTION
																			, BestPracticeType.CHUNK_SIZE
																			, BestPracticeType.CHUNK_PACING
																			, BestPracticeType.VIDEO_REDUNDANCY
																		});
		bpFileDownloadTypes.addAll(list);
	}


	@Override
	public JPanel layoutDataPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void refresh(AROTraceData model) {
		dateTraceAppDetailPanel.refresh(model);
		overViewObservable.refreshModel(model);
		updateHeader(model);
		bpResults = model.getBestPracticeResults();
	}
	
}
