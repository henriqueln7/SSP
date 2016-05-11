/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.ssp.service;

import org.jasig.ssp.service.external.BatchedTask;

import java.util.UUID;

/**
 * Exists just to give us a non-transactional location in which to launch
 * a relatively static set of scheduled jobs and clean up after them
 */
public interface ScheduledTaskWrapperService {

	/* Not scheduled through config fires every 2.5 minutes after completion*/
	public void sendMessages();

	/* Not scheduled through config fires every 2.5 minutes after completion*/
	public void processCaseloadBulkAddReassignment();

	/* Not scheduled through config fires every 5 minutes after completion*/
	public void syncCoaches();
	
	/* Not scheduled through config. runs at 1 am every day*/
	public void sendTaskReminders();

	public void syncExternalPersons();
	
	public void refreshDirectoryPerson();

	public void refreshDirectoryPersonBlue();

	public void calcMapStatusReports();
	
	public void sendEarlyAlertReminders();
	
	public void resetTaskStatus();

    public void cullOAuth1Nonces();

	void pruneMessageQueue();

	void scheduledQueuedJobs();

	void execBatchedTaskWithName(String taskName, BatchedTask batchedTask, boolean isStatusedTask, UUID runAs);

	void execWithTaskContext(String taskName, Runnable work, boolean isStatusedTask, UUID runAsId);
}
