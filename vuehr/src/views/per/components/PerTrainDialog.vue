<template>
    <el-dialog
            :visible.sync="visible"
            title="员工培训"
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
                    label="培训日期">
                <el-date-picker
                        v-model="formData.traindate"
                        type="date"
                        placeholder="选择日期">
                </el-date-picker>
            </el-form-item>
            <el-form-item
                    label="培训内容">
                <el-input type="textarea"
                          :rows="2"
                          placeholder="请输入内容"
                          clearable v-model="formData.traincontent"></el-input>
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
    import {postRequest} from "../../../utils/api";
    import EmpSearch from "../../../components/sys/EmpSearch";

    export default {
        name: "PerTrainDialog",
        components: {EmpSearch},
        data() {
            return {
                visible: false,
                formData: {
                    eid: null,
                    traindate: null,
                    traincontent: null,
                    remark: null
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
                postRequest('/personnel/train/add', this.formData).then(res => {
                    this.$emit('update')
                    this.visible = false
                })
            }
        }
    }
</script>

<style scoped>

</style>
