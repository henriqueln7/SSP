/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
Ext.define('Ssp.view.tools.profile.RecentTermActivity', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.recenttermactivity',
    mixins: ['Deft.mixin.Injectable', 'Deft.mixin.Controllable'],
    width: '100%',
    height: '100%',
    title: 'Recent Term Activity',
    autoScroll: true,
    inject: {        //store: 'recentTermActivityStore'
    },
    initComponent: function(){
        var me = this;
        Ext.applyIf(me, {
            //store: me.store,
            xtype: 'gridcolumn',
            columns: [{
                dataIndex: 'term',
                text: 'Term',
                flex: 1
            }, {
                dataIndex: 'onPlan',
                text: 'MAP',
                flex: 1
            }, {
            
                dataIndex: 'cumGPA',
                text: 'GPA',
                flex: 1
            }, {
            
                dataIndex: 'load',
                text: 'Load',
                flex: 1
            }],
            viewConfig: {}
        });
        
        me.callParent(arguments);
    }
});
