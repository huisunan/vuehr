<template>
    <el-dialog
            :visible.sync="visible"
            title="员工奖罚"
            @open="destroy = true"
            @closed="destroy = false">
        <el-form
                :model="formData"
                label-width="120px">
            <el-form-item
                    label="员工ID">
                <emp-search v-model:number="formData.eid"></emp-search>
            </el-form-item>
            <el-form-item
                    label="奖罚日期">
                <el-date-picker
                        v-model="formData.ecdate"
                        type="date"
                        placeholder="选择日期">
                </el-date-picker>
            </el-form-item>

            <el-form-item
                label="奖罚分">
                <el-input v-model:number="formData.ecpoint"></el-input>
            </el-form-item>
            <el-form-item
                label="类型">
                <el-select v-model="formData.ectype" placeholder="请选择">
                    <el-option
                            v-for="item in [{label:'奖',value:1},{label: '罚',value: 0}]"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item
                    label="原因">
                <el-input type="textarea"
                          :rows="2"
                          placeholder="请输入内容"
                          clearable v-model="formData.ecreason"></el-input>
            </el-form-item>
            <el-form-item
                    label="备注">
                <el-input type="textarea"
                          :rows="2"
                          placeholder="请输入内容"
                          clearable v-model="formData.remark"></el-input>
            </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
            <el-button @click="visible = false">取 消</el-button>
            <el-button type="primary" @click="add">确 定</el-button>
        </span>
    </el-dialog>
</template>

<script>
    import EmpSearch from "../../../components/sys/EmpSearch";
    import {postRequest} from "../../../utils/api";

    export default {
        name: "PerEcDialog",
        components: {EmpSearch},
        data() {
            return {
                visible: false,
                formData: {
                    eid: null,
                    ecdate: null,
                    ecreason: null,
                    ecpoint:null,
                    ectype:null,
                    remark:null,
                },
                destroy: true,
                allDeps: [],
                positions: [],
                defaultProps: {
                    children: 'children',
                    label: 'name'
                },
                popVisible: false,
                inputDepName: null,
            }
        }, mounted() {
            this.initPositions();
            this.initDeps()
        },
        methods: {
            add() {
                postRequest('/personnel/prize/add', this.formData).then(res => {
                    this.$emit('update')
                    this.visible = false
                })
            }
        }
    }
</script>

<style scoped>

</style>
